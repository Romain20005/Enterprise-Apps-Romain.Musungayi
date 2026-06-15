package be.ehb.enterpriseapps;

import be.ehb.enterpriseapps.model.Location;
import be.ehb.enterpriseapps.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LocationRepository locationRepository;

    public DataLoader(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) {

        if(locationRepository.count() == 0) {

            locationRepository.save(
                    new Location(
                            "Campus Kaai",
                            "Nijverheidskaai 170",
                            300
                    )
            );

            locationRepository.save(
                    new Location(
                            "Gemeente Anderlecht",
                            "Raadsplein 1",
                            500
                    )
            );

            locationRepository.save(
                    new Location(
                            "Sporthal Anderlecht",
                            "Bergensesteenweg 200",
                            200
                    )
            );
        }
    }
}