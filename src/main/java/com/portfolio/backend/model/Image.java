package com.portfolio.backend.model;

import org.yaml.snakeyaml.constructor.Construct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Image {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    public Image(){
        super();
    }

    public Image(String name, String type, byte[] content) {
		this.name = name;
		this.type = type;
		this.content = content;
	}

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "content", length = 10000000)
    private byte[] content;
}
