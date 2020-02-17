package org.kio.batbot.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "command_category")
public class CommandCategory implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

//    @OneToMany(mappedBy = "category")
//    private Set<Command> CommandList = new HashSet<>();

    public CommandCategory() { }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommandCategory{");
        sb.append("id=").append(id);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() { return id; }
    public String getLibelle() { return libelle; }

    public void setId(int id) { this.id = id; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
}
