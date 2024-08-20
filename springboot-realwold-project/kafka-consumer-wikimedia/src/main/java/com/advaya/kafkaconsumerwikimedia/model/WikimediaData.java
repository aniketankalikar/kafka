    package com.advaya.kafkaconsumerwikimedia.model;

    import jakarta.persistence.*;
    import lombok.Data;

    @Data
    @Entity
    @Table(name = "wikimedia_recentchange")
    public class WikimediaData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Lob
        @Column(name = "wikiEventData", columnDefinition = "TEXT")
        private String wikiEventData;

    }
