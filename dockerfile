From openjdk:8
copy ./target/Retail-Store-Discounts-0.0.1-SNAPSHOT.jar Retail-Store-Discounts-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","Retail-Store-Discounts-0.0.1-SNAPSHOT.jar"]