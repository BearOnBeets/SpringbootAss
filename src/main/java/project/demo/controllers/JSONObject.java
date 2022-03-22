package project.demo.controllers;

public class JSONObject {
    private long id;
    private String title;
    private String body;
    private String createdby;

    public JSONObject(long id,String title,String body,String createdby){
        super();
        this.id=id;
        this.title=title;
        this.body=body;
        this.createdby=createdby;
    }
    public long getId(){
        return this.id;
    }
       
    public String getTitle(){
        return this.title;
    }
    public String getBody(){
        return this.body;
    }
    public String getcreatedby(){
        return this.createdby;
    }
    

}
