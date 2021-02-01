package clone.vtpay.repository;


import android.text.TextUtils;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import clone.vtpay.utils.Utils;

public class HistoryItem implements Serializable {

    private String trade_code;
    private String phatsinhno;
    private String phatsinhco;
    private String noidung;
    private String thoigian;
    private String randomPhoneNumber = "";
    private boolean isluong;

    public HistoryItem(String thoigian1, String trade_code1, String phatsinhno1, String phatsinhco1, String noidung1 ) {
        this.trade_code = trade_code1;
        this.phatsinhno = phatsinhno1;
        this.phatsinhco = phatsinhco1;
        this.noidung = noidung1;
        this.thoigian = thoigian1;

        isluong = doubleMoney() > 40000000;
    }


    public boolean isIsluong() {
        return isluong;
    }

    public void setIsluong(boolean isluong) {
        this.isluong = isluong;
    }

    public String getRandomPhoneNumber() {
        return randomPhoneNumber;
    }

    public void setRandomPhoneNumber(String randomPhoneNumber) {
        this.randomPhoneNumber = randomPhoneNumber;
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

    public String getIconDrawable() {
        if (!TextUtils.isEmpty(noidung)) {
            return Utils.INSTANCE.getHistoryIcon(isluong);
        }
        return null;
    }

    public String getType() {
        if (!TextUtils.isEmpty(noidung)) {
            return noidung.substring(0, 2);
        }
        return "";
    }

    public String getMoney() {
        if (!TextUtils.isEmpty(phatsinhno) && !phatsinhno.equals("0")) {
            return "+" + formatMoney(phatsinhno) + "đ";
        }
        if (!TextUtils.isEmpty(phatsinhco) && !phatsinhco.equals("0")) {
            String pm = "-";
            if (noidung.startsWith("03")){
                pm = "+";
            }
            return pm + formatMoney(phatsinhco) + "đ";
        }
        return "";
    }

    public String formatMoney(String money) {
        String m = money.replaceAll("[,.]", "");
        double mn = Double.parseDouble(m);

        NumberFormat formatter = new DecimalFormat("#,###");
        return formatter.format(mn);
    }

    public double doubleMoney() {
        String m = phatsinhco.replaceAll("[,.]", "");
        return Double.parseDouble(m);
    }
}


