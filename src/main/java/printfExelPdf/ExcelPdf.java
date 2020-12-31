/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printfExelPdf;

import org.apache.poi.ss.usermodel.Row;

import entity.ProductEntity;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author ADMIN
 */
public class ExcelPdf extends AbstractXlsView {

    @Override
    public void buildExcelDocument(Map<String, Object> model, Workbook workbook, 
            HttpServletRequest requets, HttpServletResponse response) 
            throws Exception {

        Sheet sheet = workbook.createSheet("Product List");
        setExcelHeader(sheet);

        List<ProductEntity> productList = (List<ProductEntity>) model.get("productList");
        setExcelRows(sheet, productList);

    }

    public void setExcelHeader(Sheet sheet) {
        Row excelHeader = sheet.createRow(0);
        excelHeader.createCell(0).setCellValue("id");
        excelHeader.createCell(1).setCellValue("name");
   
        excelHeader.createCell(3).setCellValue("price");
        
//        excelHeader.createCell(3).setCellValue("chieuDai");
//        excelHeader.createCell(4).setCellValue("chieuRong");
//        excelHeader.createCell(5).setCellValue("chieuCao");
        excelHeader.createCell(6).setCellValue("canNang");
        excelHeader.createCell(7).setCellValue("kieuManHinh");
        excelHeader.createCell(8).setCellValue("boNhoTrong");
        excelHeader.createCell(4).setCellValue("ram");
        excelHeader.createCell(5).setCellValue("pin");
    }

    public void setExcelRows(Sheet sheet, List<ProductEntity> productList) {
        int record = 1;
        for (ProductEntity product : productList) {
            Row excelRow = sheet.createRow(record++);
            excelRow.createCell(0).setCellValue(product.getId());
            excelRow.createCell(1).setCellValue(product.getName());
       
            excelRow.createCell(3).setCellValue(product.getPrice());
//            excelRow.createCell(3).setCellValue(product.getProductdetails().getChieuDai());
//          excelRow.createCell(4).setCellValue(product.getProductdetails().getChieuRong());
//            excelRow.createCell(5).setCellValue(product.getProductdetails().getChieuCao());
            excelRow.createCell(6).setCellValue(product.getProductdetails().getCanNang());
            excelRow.createCell(7).setCellValue(product.getProductdetails().getKieuManHinh());
            excelRow.createCell(8).setCellValue(product.getProductdetails().getBoNhoTrong());
            excelRow.createCell(4).setCellValue(product.getProductdetails().getRam());
            excelRow.createCell(5).setCellValue(product.getProductdetails().getPin());
        }
    }
}
