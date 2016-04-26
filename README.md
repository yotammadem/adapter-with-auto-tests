# adapter-with-auto-tests
MobileFirst Java adapter with automatic integration tests (sample)

1. Build the adapter and deploy it to a running MFP server:

```
mvn clean install adapter:deploy
```


2. Run automated tests:

```
mvn failsafe:verify
```
