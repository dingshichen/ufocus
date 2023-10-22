package cn.dsc.ufocus.param;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ding.shichen
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Base implements IBase {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
