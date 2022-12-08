package ru.pasha.yetAnotherDiskRepeat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "system_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"children", "previousVersion"})
@EqualsAndHashCode(exclude = {"children", "previousVersion"})
public class SystemItem {

    @Id
    @Column(name = "id")
    private String id;

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
    private long size;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private SystemItem parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<SystemItem> children;

    @Setter(value = AccessLevel.NONE)
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private SystemItemHistory previousVersion;

    public void setPreviousVersion(SystemItemHistory previousVersion) {
        this.previousVersion = previousVersion;
        previousVersion.setCurrentVersion(this);
    }
}
