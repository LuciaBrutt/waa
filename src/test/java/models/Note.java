package models;

public class Note {
    private String title;
    private String person;
    private String message;

    public Note(String title, String person, String message) {
        this.title = title;
        this.person = person;
        this.message = message;
    }

    public String getTitle(){
        return title;
    }

    public String getPerson(){
        return person;
    }

    public String getMessage(){
        return message;
    }
}
