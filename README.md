# WallapopChallenge


<a href='https://coveralls.io/github/SammyJankis/WallapopChallenge?branch=develop'><img src='https://coveralls.io/repos/github/SammyJankis/WallapopChallenge/badge.svg?branch=develop' alt='Coverage Status' /></a>

<a href='https://travis-ci.org/SammyJankis/WallapopChallenge/builds'><img src='https://travis-ci.org/SammyJankis/WallapopChallenge.svg?branch=develop' alt='Build Travis Status' /></a>
==========
Android test project using the marvel developer api.

# Usage

Head over to [developer.marvel.com](http://developer.marvel.com) and sign up/in
to get your API keys. Initialize an API client using the public and private API keys for your
account, setting them in PrivateConstants.java class.

```java
public class PrivateConstants {

    /*TODO : ADD PRIVATE KEY HERE*/
    public static final String PRIVATE_KEY = "";

    /*TODO : ADD PUBLIC KEY HERE*/
    public static final String PUBLIC_KEY = "";
}
```