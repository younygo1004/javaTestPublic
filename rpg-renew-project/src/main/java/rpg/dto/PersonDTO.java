package rpg.dto;

public class PersonDTO {

    private String name;
    private int like;

    public PersonDTO() {}

    public PersonDTO(String name, int like) {
        this.name = name;
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "[NPC]" +
                " 이름 : " + name + " / " +
                "호감도 : " + like;
    }
}
