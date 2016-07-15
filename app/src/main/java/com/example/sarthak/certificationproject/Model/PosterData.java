package com.example.sarthak.certificationproject.Model;

import java.io.Serializable;

/**
 * Created by Sarthak on 2/8/2016.
 */
public class PosterData implements Serializable {

    public final String medium;
    public final String thumb;
    public final String full;

    public PosterData(String medium, String thumb, String full) {
        this.medium = medium;
        this.thumb = thumb;
        this.full = full;
    }
}
