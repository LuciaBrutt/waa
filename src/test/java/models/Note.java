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

    public String getTitle() {
        return title;
    }

    public String getPerson() {
        return person;
    }

    public String getMessage() {
        return message;
    }

    //  public void setTitle(String title) {
    // this.title = title;
    //}

    //public void setPerson(String person) {
    // this.person = person;
    //}

    //public void setMessage(String message) {
    //this.message = message;
//}

//public static void main (String[] args) {
    // Note note = new Note ("titulok 1 ", null, "sprava 1");
    //System.out.println(note.getTitle());
    //note.setTitle("titulok 2");
}
