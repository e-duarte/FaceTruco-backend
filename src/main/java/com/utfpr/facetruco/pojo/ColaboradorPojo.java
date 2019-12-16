package com.utfpr.facetruco.pojo;

import java.util.List;

public class ColaboradorPojo{
    private Long albumId;
    private List<String> colabs;

    public ColaboradorPojo() { }
    
    public ColaboradorPojo(Long albumId, List<String> colabs) {
        this.albumId = albumId;
        this.colabs = colabs;
    }
    
    public Long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public List<String> getColabs() {
        return this.colabs;
    }

    public void setColabs(List<String> colabs) {
        this.colabs = colabs;
    }

}