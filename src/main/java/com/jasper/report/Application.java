package com.jasper.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.CommandLineRunner;
//import com.jasper.report.bean.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    static final String fileName = "src/main/resources/EmployeeReports.jrxml";
    static final String outFile = "EmployeeReports.pdf";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employeeList = new ArrayList<Employee>();
        Map<String, Object> parameter = new HashMap<String, Object>();

        employeeList.add(new Employee(1, "Jack Ryan", 100.0));
        employeeList.add(new Employee(2, "Cathy Mueller", 130.0));
        employeeList.add(new Employee(3, "Matice", 90.0));

        JRBeanCollectionDataSource ds =  new JRBeanCollectionDataSource(employeeList);
        parameter.put("employeeDataSource", ds);
        parameter.put("title", "Employee Report");

        JasperReport jasperDesign = JasperCompileManager.compileReport(fileName);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperDesign, parameter, new JREmptyDataSource());

        File file = new File(outFile);
        OutputStream outputSteam = new FileOutputStream(file);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputSteam);

        System.out.println("Report Generated!");
    }


}


