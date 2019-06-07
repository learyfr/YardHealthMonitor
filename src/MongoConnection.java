import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.bson.Document;

import java.util.Iterator;


public class MongoConnection {

    static MongoConnection mongoClient;
    static MongoDatabase mongoDatabase;
    static MongoCollection<Document> mongoCollection;

    public static void mongo_connection(){
         // Creating a Mongo client
         mongoClient = new MongoClient( "localhost" , 27017 );
         // Selecting the database
         mongoDatabase = mongoClient.getDatabase("config");
         // Selecting the collection
         mongoCollection = mongoDatabase.getCollection("Work_Instructions");

    }

    public static void mongo_collection_print(FindIterable<Document> findIterable){
        //FindIterable<Document> iterDoc = mongoCollection.find();

        int total_doc_count = 1;
        // Getting the iterator
        Iterator it = findIterable.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            total_doc_count++;
        }

        System.out.println("total documents are "+total_doc_count);

    }

    public static void select_all_yard_containers(){

        BasicDBObject yardQuery = new BasicDBObject();
        yardQuery.put("Unit T-State","Yard");

        BasicDBObject displayFields = new BasicDBObject();
        displayFields.put("Unit T-State",1);
        //displayFields.put("Kind",1);
        //displayFields.put("Unit Nbr",1);
        //displayFields.put("Move #",1);
        //displayFields.put("Unit Position",1);
        //displayFields.put("Est mv Time",1);



        //FindIterable<Document> findIterable = mongoCollection.find(yardQuery);

        //DBCursor dbCursor=mongoCollection.find(yardQuery,displayFields);

        FindIterable<Document> findIterable= mongoCollection.find(yardQuery).projection(displayFields);


        // Print the collections matching the where query
        mongo_collection_print(findIterable);




    }




    public static void main(String[] args) {

        // Mongo Connection Driver
        mongo_connection();

        //Collection Operations
        select_all_yard_containers();




    }
}
