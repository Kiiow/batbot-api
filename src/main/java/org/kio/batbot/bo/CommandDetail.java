package org.kio.batbot.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "command_detail")
public class CommandDetail implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "example")
    private String example;

    @Column(name = "text_EN")
    @Type(type = "text")
    private String text_EN;

    @Column(name = "text_FR")
    @Type(type = "text")
    private String text_FR;

//    @OneToMany(mappedBy = "helpData")
//    private Set<Command> CommandList = new HashSet<>();

    public CommandDetail() { }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommandDetail{");
        sb.append("id=").append(id);
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", example='").append(example).append('\'');
        sb.append(", text_EN='").append(text_EN).append('\'');
        sb.append(", text_FR='").append(text_FR).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() { return id; }
    public String getIcon() { return icon; }
    public String getExample() { return example; }
    public String getText_EN() { return text_EN; }
    public String getText_FR() { return text_FR; }

    public void setId(int id) { this.id = id; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setExample(String example) { this.example = example; }
    public void setText_EN(String text_EN) { this.text_EN = text_EN; }
    public void setText_FR(String text_FR) { this.text_FR = text_FR; }
}
