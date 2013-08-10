package au.com.blogspot.ojitha.gwtex2.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import au.com.blogspot.ojitha.gwtex2.client.StateService;
import au.com.blogspot.ojitha.gwtex2.shared.StateDto;
import au.com.blogspot.ojitha.server.domain.State;
import au.com.blogspot.ojitha.server.service.StateBusinessService;
import au.com.blogspot.ojitha.server.spring.GWTSpringAwareContext;


public class StateServiceImpl extends GWTSpringAwareContext implements StateService {

	@Autowired
	StateBusinessService stateBusinessServices;
	@Override
	public List<StateDto> getAllStates() {
		List<StateDto> allStateDtos = new ArrayList<StateDto>();
		List<State> allStates = this.stateBusinessServices.findAll();
		if (allStates.size()>0){

			for (State state : allStates) {
				StateDto stateDto = new StateDto();
				BeanUtils.copyProperties(state, stateDto);
				allStateDtos.add(stateDto);
			}
		}
		return allStateDtos;
	}
}
