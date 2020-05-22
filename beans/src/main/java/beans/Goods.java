package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    private String goodsId;
    private String goodsName;
    private double price;
}
