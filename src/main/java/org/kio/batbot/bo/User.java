package org.kio.batbot.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "level")
    private int level;

    @Column(name = "xp")
    private int xp;

    @Column(name = "ts_last_xp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts_last_xp;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "username")
    private String username;

    @Column(name = "discriminator")
    private String discriminator;

    public User() { }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", level=").append(level);
        sb.append(", xp=").append(xp);
        sb.append(", ts_last_xp=").append(ts_last_xp);
        sb.append(", admin=").append(admin);
        sb.append(", username='").append(username).append('\'');
        sb.append(", discriminator='").append(discriminator).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() { return id; }
    public String getNickname() { return nickname; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }
    public Date getTs_last_xp() { return ts_last_xp; }
    public Boolean getAdmin() { return admin; }
    public String getUsername() { return username; }
    public String getDiscriminator() { return discriminator; }

    public void setId(String id) { this.id = id; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setLevel(int level) { this.level = level; }
    public void setXp(int xp) { this.xp = xp; }
    public void setTs_last_xp(Date ts_last_xp) { this.ts_last_xp = ts_last_xp; }
    public void setAdmin(Boolean admin) { this.admin = admin; }
    public void setUsername(String username) { this.username = username; }
    public void setDiscriminator(String discriminator) { this.discriminator = discriminator; }
}
