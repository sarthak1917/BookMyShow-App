package com.example.sarthak.certificationproject.Model;

import java.io.Serializable;

/**
 * Created by Sarthak on 2/8/2016.
 */
public class MovieData implements Serializable {
  public final double rating;
  public final String language;
  public final String title;
  public final String released;
  public final ImageModel images;
  public final String overview;
    public final String trailer;
    public final String tagline;
    public final String certification;
    public final String[] genres;
    public final String runtime;

    public MovieData(double rating, String language, String title, String released, ImageModel images, String overview, String trailer, String tagline, String certification, String[] genres, String runtime) {
        this.rating = rating;
        this.language = language;
        this.title = title;
        this.released = released;
        this.images = images;
        this.overview = overview;
        this.trailer = trailer;
        this.tagline = tagline;
        this.certification = certification;
        this.genres = genres;
        this.runtime = runtime;
    }
}
