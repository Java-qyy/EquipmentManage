package com.hbsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.hbsi.dao.EquipmentDao;
import com.hbsi.entity.Equipment;
import com.hbsi.entity.EquipmentType;
import com.hbsi.entity.Page;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EquipmentService {

    @Autowired
    public EquipmentDao equipmentDao;

    @Autowired
    SolrClient solrClient;

    public Map<String,Object> findAll(Page page) throws SolrServerException, IOException {
        Map<String,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

       // HttpSolrClient solrClient = new HttpSolrClient.Builder("http://127.0.0.1:8089/solr/collection1").build();
        // 创建搜索对象
        SolrQuery query = new SolrQuery();
        // 设置搜索条件
        if (StringUtils.hasText(page.getQueryString())){
            query.set("q", "ename:*"+page.getQueryString()+"*");
        }else {
            query.set("q", "*");
        }
        query.setStart(page.getPage()-1);
        query.setRows(page.getSize());

        //发起搜索请求
        QueryResponse response = solrClient.query(query);

        // 查询结果
        SolrDocumentList docs = response.getResults();
        // 查询结果总数
        long cnt = docs.getNumFound();
        System.out.println("总条数为"+cnt+"条");
        List<Equipment> list = new ArrayList<>();
        for (SolrDocument doc : docs) {
            Equipment equipment = new Equipment();
            equipment.setEid( Integer.parseInt(doc.get("eid")+""));
            equipment.setEname(""+doc.get("ename"));
            equipment.setEquipmentType(mapper.readValue(doc.get("equipmenttype")+"",EquipmentType.class) );
            equipment.setEprice(Double.parseDouble(doc.get("eprice")+""));
            equipment.setEcount(Integer.parseInt(doc.get("ecount")+""));

            list.add(equipment);
        }
//        solrClient.close();
        map.put("data",list);
        map.put("total",cnt);
        map.put("msg","查询成功");
        map.put("flag",true);
        return map;

    }

    public int add( String name, Integer etid, double eprice, Integer ecount) {
        return equipmentDao.add(name,etid,eprice,ecount);
    }


    public int removeCount(Integer eid,Integer ecount) {
        return equipmentDao.removeCount(eid,ecount);
    }




    public void create() throws SolrServerException, IOException {
        //HttpSolrClient solrClient = new HttpSolrClient.Builder("http://127.0.0.1:8089/solr/collection1").build();
        ObjectMapper mapper = new ObjectMapper();

        List<Equipment> list =equipmentDao.findAll();
        int count=0;
        for (Equipment stringObjectMap : list) {
            //创建索引文档对象
            SolrInputDocument doc1 = new SolrInputDocument();
            doc1.addField("eid",stringObjectMap.getEid());
            doc1.addField("ename",stringObjectMap.getEname());
            doc1.addField("equipmenttype",mapper.writeValueAsString(stringObjectMap.getEquipmentType()) );
            doc1.addField("eprice",stringObjectMap.getEprice());
            doc1.addField("ecount",stringObjectMap.getEcount());
            List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
            docs.add(doc1);
            //3.将文档写入索引库中
            solrClient.add(docs);
            solrClient.commit();
        }
    }

}
