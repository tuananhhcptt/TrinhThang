package clone.vtpay.repository;

public class HistoryItem {
    private String trade_code;
    private String phatsinhno;
    private String phatsinhco;
    private String noidung;
    private String thoigian;

    public HistoryItem(String trade_code1, String phatsinhno1, String phatsinhco1, String noidung1, String thoigian1) {
        this.trade_code = trade_code1;
        this.phatsinhno = phatsinhno1;
        this.phatsinhco = phatsinhco1;
        this.noidung = noidung1;
        this.thoigian = thoigian1;
    }

    public String getTrade_code() {
        return trade_code;
    }

    public void setTrade_code(String trade_code) {
        this.trade_code = trade_code;
    }

    public String getPhatsinhno() {
        return phatsinhno;
    }

    public void setPhatsinhno(String phatsinhno) {
        this.phatsinhno = phatsinhno;
    }

    public String getPhatsinhco() {
        return phatsinhco;
    }

    public void setPhatsinhco(String phatsinhco) {
        this.phatsinhco = phatsinhco;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    @Override
    public String toString() {
        return "HistoryItem{" +
                "trade_code='" + trade_code + '\'' +
                ", phatsinhno='" + phatsinhno + '\'' +
                ", phatsinhco='" + phatsinhco + '\'' +
                ", noidung='" + noidung + '\'' +
                ", thoigian='" + thoigian + '\'' +
                '}';
    }
}
