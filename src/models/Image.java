package models;

import java.util.ArrayList;

public class Image {

        private int id;
        private int id_logement;
        private String images;

        public Image(int id, int id_logement, String images) {
            this.id = id;
            this.id_logement = id_logement;
            this.images = images;
        }

        public int getId() {
            return id;
        }

        public int getId_logement() {
            return id_logement;
        }

        public String getImages() {
            return images;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setId_logement(int id_logement) {
            this.id_logement = id_logement;
        }

        public void setImages(String images) {
            this.images = images;
        }
    }
