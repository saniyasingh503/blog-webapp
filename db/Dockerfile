# Use official MongoDB image as the base image
FROM mysql:latest

# Expose the default MongoDB port
EXPOSE 3306

# Use the default MySQL entrypoint
ENTRYPOINT ["docker-entrypoint.sh"]

# Start the MySQL server
CMD ["mysqld"]
