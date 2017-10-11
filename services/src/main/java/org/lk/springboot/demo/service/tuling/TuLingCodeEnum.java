package org.lk.springboot.demo.service.tuling;

public enum  TuLingCodeEnum {

    TEXT("100000", "文本类"),
    URL("200000", "链接类"),
    NEWS("302000", "新闻类"),
    MENU("308000", "菜谱类"),
    SONG("313000", "儿歌类"),
    POETRY("314000", "诗词类"),
    ;

    TuLingCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}

}
