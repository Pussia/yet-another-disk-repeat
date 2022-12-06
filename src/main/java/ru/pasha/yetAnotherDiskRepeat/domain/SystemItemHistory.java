package ru.pasha.yetAnotherDiskRepeat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
@Table(name = "system_item_history")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SystemItemHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date date;

    @Column(name = "parent_link")
    private String parentId;

    @Enumerated
    @Column(name = "type", nullable = false)
    private SystemItemType type;

    @Column(name = "size")
    private Long size;

    @OneToOne(mappedBy = "child")
    private SystemItemHistory parent;

    @OneToOne(cascade = {CascadeType.REMOVE})
    private SystemItemHistory child;

    @OneToOne(mappedBy = "previousVersion")
    private SystemItem currentVersion;

    public SystemItemHistory(String url, Date date, String parentId, SystemItemType type, Long size) {
        this.url = url;
        this.date = date;
        this.parentId = parentId;
        this.type = type;
        this.size = size;
    }

    public void addParent(SystemItemHistory parent) {
        this.setParent(parent);
        parent.setChild(this);
    }
}
