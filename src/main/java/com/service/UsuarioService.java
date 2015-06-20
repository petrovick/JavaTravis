package com.service;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.Utils.Helper;
import com.business.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
public class UsuarioService
{
	public void main(User user) throws UnknownHostException
	{
		

        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        ObjectId id = new ObjectId();
        docBuilder.add("_id", id);
        docBuilder.append("name", user.getName());
        docBuilder.append("role", user.getRole());
        docBuilder.append("isEmployee", user.isEmployee());
        DBObject doc = docBuilder.get();
        Gson gson = new Gson();
        User uu = gson.fromJson(doc.toString(), User.class);

        MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
        MongoClient mongo = new MongoClient(uri);
        DB db = mongo.getDB("nodepivii");
        DBCollection col = db.getCollection("nodepivii");
        WriteResult result = col.insert(doc);
        DBObject query = BasicDBObjectBuilder.start().add("_id", user.get_id()).get();
        //update example
        user.setName("Pankaj Kumar");
        result = col.update(query, doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());
         
        //delete example
        result = col.remove(query);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());
         
        //close resources
        mongo.close();
	}
	
	public String create(User user)
    {
    	String mensagem = null;
    	try
    	{
            MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
            MongoClient mongo = new MongoClient(uri);
            DB db = mongo.getDB("nodepivii");
	        DBCollection col = db.getCollection("nodepivii");
	        
	        //create user

	        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
	        ObjectId id = new ObjectId();
	        docBuilder.add("_id", id);
	        docBuilder.append("name", user.getName());
	        docBuilder.append("role", user.getRole());
	        docBuilder.append("isEmployee", user.isEmployee());
	        
	        DBObject doc = docBuilder.get();
	        WriteResult result = col.insert(doc);
	        System.out.println(result.getUpsertedId());
	        System.out.println(result.getN());
	        System.out.println(result.isUpdateOfExisting());
	        System.out.println(result.getLastConcern());
	        user.set_id(id);
	        mongo.close();
    	}
    	catch(Exception ex)
    	{
    		mensagem = ex.getMessage();
    	}
    	return mensagem;
    }
    
    public User obter(ObjectId idUser)
    {
    	User user = null;
    	try
    	{

            MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
            MongoClient mongo = new MongoClient(uri);
            DB db = mongo.getDB("nodepivii");
	        DBCollection col = db.getCollection("nodepivii");
	        //read example
	        DBObject query = BasicDBObjectBuilder.start().add("_id", idUser).get();
	        DBCursor cursor = col.find(query);
	        if(cursor.hasNext()){
	            user = Helper.toObject(cursor.next().toString());
	        }
	        //close resources
	        mongo.close();
	    	return user;
    	}
    	catch(Exception ex)
    	{
    		return null;
    	}
    }
    
    public User update(User user) throws UnknownHostException
    {
        MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
        MongoClient mongo = new MongoClient(uri);
        DB db = mongo.getDB("nodepivii");
        DBCollection col = db.getCollection("nodepivii");
        
		//update example
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        ObjectId id = new ObjectId();
        docBuilder.add("_id", id);
        docBuilder.append("name", user.getName());
        docBuilder.append("role", user.getRole());
        docBuilder.append("isEmployee", user.isEmployee());
        DBObject doc = docBuilder.get();
		DBObject query = BasicDBObjectBuilder.start().add("_id", user.get_id()).get();
        WriteResult result = col.update(query, doc);
        //close resources
        mongo.close();
    	return user;
    }
    
    public List<User> todos()
    {
    	User user = null;
    	try
    	{

            MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
            MongoClient mongo = new MongoClient(uri);
            DB db = mongo.getDB("nodepivii");
	        DBCollection col = db.getCollection("nodepivii");
	        //read example
	        DBCursor cursor = col.find();
	        List<User> users = new ArrayList<User>();
	        if(cursor.hasNext()){
	        	User u = Helper.toObject(cursor.next().toString());
	            users.add(u);
	        }
	        //close resources
	        mongo.close();
	    	return users;
    	}
    	catch(Exception ex)
    	{
    		return null;
    	}
    }
    
    
    
}
