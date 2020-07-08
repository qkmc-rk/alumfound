package org.whystudio.alumfound.constant;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 标注一些常用sql失败或不能执行的状态，
 * 便于后续添加错误返回信息。我也不知道有没有用，先放着。
 * @author Jason
 * @version 1.0
 * @createTime 2020/6/23 10:45
 * @modify 2020/6/23 10:45
 */
public final class SQLResult {

    public static final int EXIST_DATA = -3;

    public static final int NO_RECORD = -2;

    public static final int ACTION_FAILED = -1;

    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(EXIST_DATA, "数据已存在");
        map.put(NO_RECORD, "记录不存在");
        map.put(ACTION_FAILED, "操作失败");
    }

    public static final String errorMsg(Integer result){
        return map.get(result);
    }

}
