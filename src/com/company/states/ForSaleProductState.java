package com.company.states;

import com.company.CodeGenerator;
import com.company.Product;
import com.company.State;
import com.company.strategy.Bronze;
import com.company.strategy.Gold;
import com.company.strategy.Silver;

public class ForSaleProductState extends ProductState{

    private final Integer fixedValue = 100;

    @Override
    public void raisePrice(Product product) {
        product.setPrice(product.getPrice() + fixedValue);
        System.out.println("Цена успешно повышена.");
    }

    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("Товар уже участвует в торгах");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        if (product.getPrice() == 0) {
            throw new Exception("нельзя отдать товар бесплатно");
        } else {
            CodeGenerator codeGenerator = new CodeGenerator();
            product.setState(State.sold);
            product.setStateClass(new SoldProductState());

            if (product.getPrice() >= 1000) {
                product.setHonorary_code(new Gold().makeCode(product.getId()));
            } else if (product.getPrice() >=500 && product.getPrice() < 1000) {
                product.setHonorary_code(new Silver().makeCode(product.getId()));
            } else if (product.getPrice() < 500){
                product.setHonorary_code(new Bronze().makeCode(product.getId()));
            }

//            if (product.getPrice() >= 1000) {
//                product.setHonorary_code(new Gold().makeCode(product.getId()));
//                product.setHonorary_code(codeGenerator.makeCode("Gold-" + product.getId()));
//            } else if (product.getPrice() >=500 && product.getPrice() < 1000) {
//                product.setHonorary_code(codeGenerator.makeCode("Silver-" + product.getId()));
//            } else if (product.getPrice() < 500){
//                product.setHonorary_code(codeGenerator.makeCode("Bronze-" + product.getPrice()));
//            }
            System.out.println("Состояние успешно изменилось. Товар продан");
        }
     }

    @Override
    public void withdraw(Product product) throws Exception {
        if (product.getPrice() > product.getStartPrice()) {
            throw new Exception("Цена уже была поднята, нельзя вернуть товар на склад");
        } else {
            product.setState(State.in_stock);
            product.setStateClass(new InStockProductState());
            System.out.println("Состояние успешно изменилось. Товар снят с торгов");
        }
    }
}

