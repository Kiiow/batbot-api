package org.kio.batbot.domain;

public class UserRequestBody {
    private String nickname;
    private String username;
    private String discriminator;
    private Integer xp;
    private Integer level;

    public UserRequestBody() { }

    public Integer getXp() { return xp; }
    public Integer getLevel() { return level; }
    public String getNickname() { return nickname; }
    public String getUsername() { return username; }
    public String getDiscriminator() { return discriminator; }

    public void setXp(int xp) { this.xp = xp; }
    public void setLevel(int level) { this.level = level; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setUsername(String username) { this.username = username; }
    public void setDiscriminator(String discriminator) { this.discriminator = discriminator; }
}
