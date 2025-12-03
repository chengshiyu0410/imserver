sudo docker logs -f --tail 100 my-app



sudo docker logs my-app | grep "ERROR"


sudo docker inspect --format='{{.LogPath}}' my-app