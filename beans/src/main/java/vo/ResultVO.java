package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ����һ��
 * ����:2020/5/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String msg;
    private Object data;



}
