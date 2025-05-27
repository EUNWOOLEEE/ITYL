package sec03;

import app.Database;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.bson.Document;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        String id = "6835279e725951770e98026c";
        Bson query = eq("_id", new ObjectId(id));

        Document doc = collection.find(query).first();
        System.out.println("==> findByIdResult : " + doc);

        Database.close();
    }
}
