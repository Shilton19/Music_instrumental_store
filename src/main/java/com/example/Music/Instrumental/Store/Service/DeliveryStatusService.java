package com.example.Music.Instrumental.Store.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Music.Instrumental.Store.Model.DeliveryStatus;
import com.example.Music.Instrumental.Store.Model.DeliveryStatusNotFoundException;
import com.example.Music.Instrumental.Store.Repository.DeliveryStatusRepository;
@Service
public class DeliveryStatusService {
	@Autowired
	DeliveryStatusRepository deliverystatusrepository;

	public List<DeliveryStatus> getMusic() {
		// TODO Auto-generated method stub
		List<DeliveryStatus> del = deliverystatusrepository.findAll();
		return del;
	}

	public DeliveryStatus getMusicId(int id) throws DeliveryStatusNotFoundException {
		Optional<DeliveryStatus> deli = deliverystatusrepository.findById(id);
		if (deli.isPresent()) {
			DeliveryStatus del = deli.get();
			return del;
		} else {
			throw new DeliveryStatusNotFoundException("Delivery Status Unavailable");
		}
	}

	public DeliveryStatus createmusic(DeliveryStatus DeliveryStatus) {
		DeliveryStatus deli = deliverystatusrepository.save(DeliveryStatus);
		return deli;
	}

	public DeliveryStatus UpdateMusic(DeliveryStatus deliverystatus, int id) throws DeliveryStatusNotFoundException {
		Optional<DeliveryStatus> deli = deliverystatusrepository.findById(deliverystatus.getId());
		if (deli.isPresent()) {
			DeliveryStatus deliv = deli.get();
			if (deliverystatus.getName() != null) { // --doubt
				deliv.setName(deliverystatus.getName()); // -----doubt
			}
			if (deliverystatus.getMobile() != null) {
				deliv.setMobile(deliverystatus.getMobile()); // ------doubt
			}
			if (deliverystatus.getAddress() != null) {
				deliv.setAddress(deliverystatus.getAddress());
			}
			return deliverystatusrepository.save(deliv);
		} else {
			throw new DeliveryStatusNotFoundException("Given data is not found");
		}
	}

	public void deletemusic(int id) throws DeliveryStatusNotFoundException {
		Optional<DeliveryStatus> del = deliverystatusrepository.findById(id);
		if (del.isPresent()) {
			deliverystatusrepository.deleteById(id);
		} else {
			throw new DeliveryStatusNotFoundException("Given data is not found");
		}
	}
}
