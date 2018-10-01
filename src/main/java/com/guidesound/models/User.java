package com.guidesound.models;

/**
 * 用户表
 */
public class User {
    private int id;
    private String unionid;
    private String name;
    private int type;
    private int status;
    private int follow_num;
    private int funs_num;
    private String sign_name;
    private int sex;
    private int teach_age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFollow_num() {
        return follow_num;
    }

    public void setFollow_num(int follow_num) {
        this.follow_num = follow_num;
    }

    public int getFuns_num() {
        return funs_num;
    }

    public void setFuns_num(int funs_num) {
        this.funs_num = funs_num;
    }

    public String getSign_name() {
        return sign_name;
    }

    public void setSign_name(String sign_name) {
        this.sign_name = sign_name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getTeach_age() {
        return teach_age;
    }

    public void setTeach_age(int teach_age) {
        this.teach_age = teach_age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", unionid='" + unionid + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", follow_num=" + follow_num +
                ", funs_num=" + funs_num +
                ", sign_name='" + sign_name + '\'' +
                ", sex=" + sex +
                ", teach_age=" + teach_age +
                '}';
    }
}
