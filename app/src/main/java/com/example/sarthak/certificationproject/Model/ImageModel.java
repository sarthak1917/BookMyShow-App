package com.example.sarthak.certificationproject.Model;

import java.io.Serializable;

/**
 * Created by Sarthak on 2/8/2016.
 */
public class ImageModel implements Serializable{

    public final PosterData poster;

    public ImageModel(PosterData poster) {
        this.poster = poster;
    }
}
