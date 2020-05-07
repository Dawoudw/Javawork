package dev.sun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.sun.entities.Topping;
import dev.sun.repositories.ToppingRepository;

@Component
@Service
public class ToppingServiceImpl implements ToppingService {

	@Autowired
	ToppingRepository tr;
	@Override
	public Topping createTopping(Topping topping) {
		return tr.save(topping);
	}

	@Override
	public List<Topping> getAllToppings() {
		return (List<Topping>) tr.findAll();
	}

	@Override
	public Topping getToppingById(int id) {
		return tr.findById(id).get();
	}

	@Override
	public Topping updateTopping(Topping topping) {
		Topping toppingFromdb  = tr.findById(topping.getToppingId()).get();
		toppingFromdb.setToppingCost(topping.getToppingCost());
		toppingFromdb.setToppingName(topping.getToppingName());
		return tr.save(toppingFromdb);
	}

	@Override
	public boolean deleteTopping(Topping topping) {
		tr.delete(topping);
		return true;
	}

}
