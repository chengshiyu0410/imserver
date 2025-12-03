sudo docker logs -f --tail 100 imserver



sudo docker logs imserver | grep "ERROR"


sudo docker inspect --format='{{.LogPath}}' imserver