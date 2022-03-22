package project.demo.controllers;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class checkcontroller {

    ArrayList<String> users = new ArrayList<String>();
    ArrayList<String> passwords  = new ArrayList<String>();
    ArrayList<String> title  = new ArrayList<String>();
    ArrayList<String> body  = new ArrayList<String>();
    ArrayList<String> createdby  = new ArrayList<String>();

    @PostMapping("/signup")
    @CrossOrigin(origins = "*")
    public String signup(@RequestBody String data) throws JsonMappingException, JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        String name=rootNode.get("name").asText();
        String Password=rootNode.get("password").asText();
        // System.out.println(name+Password);
        // users[0]="Keyur123";
        // users.add("Volvo");
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).equals(name))
            {
                return "-1";
            }
        }
        users.add(name);
        passwords.add(Password);
        System.out.println(users);
        System.out.println(passwords);
        return name;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public String login(@RequestBody String data) throws JsonMappingException, JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        String name=rootNode.get("name").asText();
        String Password=rootNode.get("password").asText();
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).equals(name))
            {
                if(passwords.get(i).equals(Password))
                {
                    return users.get(i);
                }
            }
        }
        return "-1";
        // return ResponseEntity.ok()
        // .header("Access-Control-Allow-Origin","*")
        // .body("Custom header set");
        
    }

    @GetMapping("/blogs")
    @CrossOrigin(origins = "*")
    public List<JSONObject> allblogs(){
        // title.add("title1");
        // body.add("body1");
        // title.add("title2");
        // body.add("body2");
        List<JSONObject> list;
        list=new ArrayList<>();
        for(int i=0;i<title.size();i++)
        {
            list.add(new JSONObject(i,title.get(i),body.get(i),createdby.get(i)));
        }  
        return list;
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "*")
    public int create(@RequestBody String data) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        String t=rootNode.get("title").asText();
        String b=rootNode.get("body").asText();
        String c=rootNode.get("createdby").asText();
        title.add(t);
        body.add(b);
        createdby.add(c);
        return 1;
    }
}
