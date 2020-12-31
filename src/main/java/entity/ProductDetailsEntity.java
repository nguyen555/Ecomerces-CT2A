/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "productdetails")
public class ProductDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String chieuDai;
    private String chieuRong;
    private String chieuCao;
    private String canNang;
    private String KieuManHinh;
    private String KichThuocManHinh;
    private String doPhanGiai;
    private String cacTinhNangKhac;
    private String jackCamAudio;
    private String boNhoTrong;
    private String TheNho;
    private String hoTro3g;
    private String mayAnh;
    private String quayPhim;
    private String sim;
    private String kieuDang;
    private String heDieuHanh;
    private String cpu;
    private String ram;
    private String pin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate time_of_launch;

    @OneToMany(mappedBy = "productdetails", fetch = FetchType.LAZY)
    List<ProductEntity> productList;

    public ProductDetailsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(String chieuDai) {
        this.chieuDai = chieuDai;
    }

    public String getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(String chieuRong) {
        this.chieuRong = chieuRong;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

    public String getKieuManHinh() {
        return KieuManHinh;
    }

    public void setKieuManHinh(String KieuManHinh) {
        this.KieuManHinh = KieuManHinh;
    }

    public String getKichThuocManHinh() {
        return KichThuocManHinh;
    }

    public void setKichThuocManHinh(String KichThuocManHinh) {
        this.KichThuocManHinh = KichThuocManHinh;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public String getCacTinhNangKhac() {
        return cacTinhNangKhac;
    }

    public void setCacTinhNangKhac(String cacTinhNangKhac) {
        this.cacTinhNangKhac = cacTinhNangKhac;
    }

    public String getJackCamAudio() {
        return jackCamAudio;
    }

    public void setJackCamAudio(String jackCamAudio) {
        this.jackCamAudio = jackCamAudio;
    }

    public String getBoNhoTrong() {
        return boNhoTrong;
    }

    public void setBoNhoTrong(String boNhoTrong) {
        this.boNhoTrong = boNhoTrong;
    }

    public String getTheNho() {
        return TheNho;
    }

    public void setTheNho(String TheNho) {
        this.TheNho = TheNho;
    }

    public String getHoTro3g() {
        return hoTro3g;
    }

    public void setHoTro3g(String hoTro3g) {
        this.hoTro3g = hoTro3g;
    }

    public String getMayAnh() {
        return mayAnh;
    }

    public void setMayAnh(String mayAnh) {
        this.mayAnh = mayAnh;
    }

    public String getQuayPhim() {
        return quayPhim;
    }

    public void setQuayPhim(String quayPhim) {
        this.quayPhim = quayPhim;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public LocalDate getTime_of_launch() {
        return time_of_launch;
    }

    public void setTime_of_launch(LocalDate time_of_launch) {
        this.time_of_launch = time_of_launch;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

  

  

}
