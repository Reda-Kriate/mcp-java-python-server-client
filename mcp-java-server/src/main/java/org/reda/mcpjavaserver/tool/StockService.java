package org.reda.mcpjavaserver.tool;

import org.reda.mcpjavaserver.models.Company;
import org.reda.mcpjavaserver.models.Stock;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {
    List<Company> companies = List.of(
            new Company("IAM","telecom",3.2,20000,"Maroc"),
            new Company("inwi","telecom",2.4,18000,"Maroc"),
            new Company("Orange","telecom",9.2,100000,"France"),
            new Company("OCP","energie",899.8,150000,"Maroc"),
            new Company("SNTL","transport",1.2,3000,"Maroc")
    );

    @Tool(name = "get_all_companies", description = "get all companies")
    public List<Company> getAllCompanies(){
        return companies;
    }

    @Tool(name = "get_company_by_name", description = "get company by name")
    public Company getCompanyByName(String name){
        return companies.stream().filter(c->c.name().equals(name)).findFirst().orElseThrow(
                ()-> new RuntimeException("No company with name -> " + name)
        );
    }

    @Tool(name = "get_stock_by_company_name", description = "get stock by company name")
    public Stock getStockByCompany(String name){
        return new Stock(name, LocalDate.now(),300+Math.random()*300);
    }

}
