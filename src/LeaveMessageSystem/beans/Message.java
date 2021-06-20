package LeaveMessageSystem.beans;

import javafx.beans.property.SimpleStringProperty;

public class Message {
    private int id;
    private String name;
    private String title;
    private String content;

    public Message() {
    }

    public Message(int id, String name, String title, String content, String time) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
    public SimpleStringProperty midProperty() {
        String newid=id+"";
        SimpleStringProperty idfx=new SimpleStringProperty(newid);
        return idfx;
    }
    public SimpleStringProperty mnameProperty(){
        SimpleStringProperty namefx=new SimpleStringProperty(name);
        return namefx;
    }
    public SimpleStringProperty mtitleProperty(){
        SimpleStringProperty tilefx=new SimpleStringProperty(title);
        return tilefx;
    }
    public SimpleStringProperty mcontentProperty(){
        SimpleStringProperty contentfx=new SimpleStringProperty(content);
        return contentfx;
    }
    public SimpleStringProperty mtimeProperty(){
        SimpleStringProperty timefx=new SimpleStringProperty(time);
        return timefx;
    }

}
