/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntnu.integrationproject;

import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import java.util.*;
import org.bson.Document;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;
import java.util.Map.Entry;

/**
 *
 * @author gd238947
 */
public class Connexion {
    
    // TODO code application logic here
    String s="badasse";    
    char [ ] pass = s.toCharArray();
    MongoCredential credential = MongoCredential.createCredential("editor", "project", pass);
    MongoClient client = new MongoClient(new ServerAddress("harinman.ddns.net", 27017), Arrays.asList(credential));
    MongoDatabase db = client.getDatabase("project");
    MongoCollection<Document> collection;
    // Liste des collections
    /*for (String name : db.listCollectionNames()) {
        System.out.println(name);
    }*/
    
    public MongoCollection<Document> getCollection(){
        return this.collection;
    }
    
    public Connexion(String str){
        collection = db.getCollection(str);
    }
   
    
    public List<String> requete(Map<String,Object> map){
        
        List<String> res=new ArrayList<String>();
        int temp=map.size();
        Set<Map.Entry<String, Object>> setMap = map.entrySet();
                Iterator<Map.Entry<String, Object>> it = setMap.iterator();
        switch (temp){
            case 1:{
                Entry<String, Object> e = it.next();
                List<Document> jeux = (List<Document>) collection.find(eq(e.getKey(),e.getValue())).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            case 2:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                List<Document> jeux = (List<Document>) collection.find(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            case 3:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                Entry<String, Object> g = it.next();
                List<Document> jeux = (List<Document>) collection.find(and(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue())),eq(g.getKey(),g.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;            
            }
            case 4:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                Entry<String, Object> g = it.next();
                Entry<String, Object> h = it.next();
                List<Document> jeux = (List<Document>) collection.find(and(and(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue())),eq(g.getKey(),g.getValue())),eq(h.getKey(),h.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            case 5:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                Entry<String, Object> g = it.next();
                Entry<String, Object> h = it.next();
                Entry<String, Object> i = it.next();
                List<Document> jeux = (List<Document>) collection.find(and(and(and(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue())),eq(g.getKey(),g.getValue())),eq(h.getKey(),h.getValue())),eq(i.getKey(),i.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            case 6:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                Entry<String, Object> g = it.next();
                Entry<String, Object> h = it.next();
                Entry<String, Object> i = it.next();
                Entry<String, Object> j = it.next();
                List<Document> jeux = (List<Document>) collection.find(and(and(and(and(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue())),eq(g.getKey(),g.getValue())),eq(h.getKey(),h.getValue())),eq(i.getKey(),i.getValue())),eq(j.getKey(),j.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            case 7:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                Entry<String, Object> g = it.next();
                Entry<String, Object> h = it.next();
                Entry<String, Object> i = it.next();
                Entry<String, Object> j = it.next();
                Entry<String, Object> k = it.next();
                List<Document> jeux = (List<Document>) collection.find(and(and(and(and(and(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue())),eq(g.getKey(),g.getValue())),eq(h.getKey(),h.getValue())),eq(i.getKey(),i.getValue())),eq(j.getKey(),j.getValue())),eq(k.getKey(),k.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            case 8:{
                Entry<String, Object> e = it.next();
                Entry<String, Object> f = it.next();
                Entry<String, Object> g = it.next();
                Entry<String, Object> h = it.next();
                Entry<String, Object> i = it.next();
                Entry<String, Object> j = it.next();
                Entry<String, Object> k = it.next();
                Entry<String, Object> l = it.next();
                List<Document> jeux = (List<Document>)collection.find(and(and(and(and(and(and(and(eq(e.getKey(),e.getValue()),eq(f.getKey(),f.getValue())),eq(g.getKey(),g.getValue())),eq(h.getKey(),h.getValue())),eq(i.getKey(),i.getValue())),eq(j.getKey(),j.getValue())),eq(k.getKey(),k.getValue())),eq(l.getKey(),l.getValue()))).into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
            default:{
                List<Document> jeux = (List<Document>) collection.find().into(
				new ArrayList<Document>());

		for (Document jeu : jeux) {

			res.add(jeu.getString("_id"));

		}
                break;
            }
        }
        return res;
    }
    
    public Document resultat(String id){
        
        List<Document> temp = (List<Document>) collection.find(eq("_id",id)).into(
				new ArrayList<Document>());
        Document res=null;
        if(temp.size()>0)
            res=temp.get(0);
        
        return res;
        
    }
    public void insert(Map<String,Object> map){
        Document d1=new Document();
        Set<Entry<String, Object>> setMap = map.entrySet();
        Iterator<Entry<String, Object>> it = setMap.iterator();
        while(it.hasNext()){
            Entry<String, Object> e = it.next();
            d1.append(e.getKey() , e.getValue());
        }
        collection.insertOne(d1);
    }
    
    public void suppr(String id){
        collection.deleteOne(eq("_id",id));
    }
    
    
    public void update(String id,Map<String,Object> map){
        Set<Entry<String, Object>> setMap = map.entrySet();
        Iterator<Entry<String, Object>> it = setMap.iterator();
        while(it.hasNext()){
            Entry<String, Object> e = it.next();
            collection.updateOne(eq("_id",id),set(e.getKey(),e.getValue()));
        }
    }
    public Map<String,Map<String,Double>> mapReduce(){
        // get the Avis collection
        DBCollection coll=client.getDB("gd238947").getCollection("Avis");
        // map function pour catégoriser les Notes par jeu
        String noteMap = "function (){" + "var criteria;"
                        + "{" + "criteria = this.Sujet;"
                        + "emit(criteria,this.Note);" + "}" + "};";

        // reduce function pour ajouter toutes les Notes et calculer la Note moyenne

        String noteReduce = "function(key, Note) {" + "var total =0;"
                        + "for (var i = 0; i < Note.length; i++) {"
                        + "total = total+Note[i];" + "}"
                        + "return total/Note.length;" + "};";

        // create the mapreduce command by calling map and reduce functions
        MapReduceCommand mapcmd = new MapReduceCommand(coll, noteMap, noteReduce,
                        null, MapReduceCommand.OutputType.INLINE, null);

        // invoke the mapreduce command
        MapReduceOutput notes = coll.mapReduce(mapcmd);

        // print the average Note of cars
        double min = 11;
        double max = -1;
        String minTitre="";
        String maxTitre="";

        for (DBObject o : notes.results()) {

                o.toMap();
                double value = (double) o.get("value");
                if(value>max){
                    max=value;
                    maxTitre=(String)o.get("_id");
                }
                if(value<min){
                    min=value;
                    minTitre=(String)o.get("_id");
                }   
        }
        Map<String,Double> minMap=new HashMap();
        minMap.put(minTitre,min);
        Map<String,Double> maxMap=new HashMap();
        maxMap.put(maxTitre,max);
        Map<String,Map<String,Double>> res=new HashMap();
        res.put("min",minMap);
        res.put("max",maxMap);
        return res;
    }
        
}
