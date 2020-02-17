package org.kio.batbot.bo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "command")
public class Command implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CommandCategory category;

    @ManyToOne
    @JoinColumn(name = "help_data")
    private CommandDetail helpData;

    public Command() { }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Command{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", filename='").append(filename).append('\'');
        sb.append(", active=").append(active);
        sb.append(", helpData=").append(helpData);
        sb.append('}');
        return sb.toString();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getFilename() { return filename; }
    public boolean isActive() { return active; }
    public CommandDetail getHelpData() { return helpData; }
    public CommandCategory getCategory() { return category; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setFilename(String filename) { this.filename = filename; }
    public void setActive(boolean active) { this.active = active; }
    public void setHelpData(CommandDetail helpData) { this.helpData = helpData; }
    public void setCategory(CommandCategory category) { this.category = category; }
}
