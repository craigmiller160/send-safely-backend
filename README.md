# Send Safely Backend Assessment

This is the backend coding assessment for Craig Miller's interview with Send Safely.

## Basic Overview

This application is designed to take in a series of arguments that provide SendSafely credentials, an action, and any additional information required for that action. At any point in time the current status of the package can be reviewed using the `GET_PACKAGE_INFO` action. This allows for incrementally constructing and managing the state of a package prior to sending it.

## About Undo Functionality

Since the `SendSafely` API does not appear to natively implement "undo" functionality, I chose to simply provide the ability to both add and remove all features of a package. This is the simplest solution to allow the end users to undo mistakes.

## How to Run 

The application can be run with a simple command. The arguments are a series of key/value pairs separated by an `=`. Different actions require different arguments.

```bash
gradle bootRun --args='ARGUMENTS GO HERE'
```

### Get Package Info

Get information on an existing package. This is valuable for monitoring the full state of a package as it is incrementally constructed.

**Arguments**

| Argument   | Description                                               |
|------------|-----------------------------------------------------------|
| API_KEY    | The SendSafely API Key                                    |
| API_SECRET | The SendSafely API Secret                                 |
| ACTION     | Must be `GET_PACKAGE_INFO`                                |
| PACKAGE_ID | The ID of the SendSafely Package to get information about |

**Example**

```bash
gradle bootRun --args='API_KEY=### API_SECRET=### ACTION=GET_PACKAGE_INFO PACKAGE_ID=###'
```

### Create Package

Create a brand new package and output the ID of the package.

**Arguments**

| Argument   | Description               |
|------------|---------------------------|
| API_KEY    | The SendSafely API Key    |
| API_SECRET | The SendSafely API Secret |
| ACTION     | Must be `CREATE_PACKAGE`  |

**Example**

```bash
gradle bootRun --args='API_KEY=### API_SECRET=### ACTION=CREATE_PACKAGE'
```

### Add File to Package

Add a file to an existing package.

**Arguments**

| Argument   | Description                                               |
|------------|-----------------------------------------------------------|
| API_KEY    | The SendSafely API Key                                    |
| API_SECRET | The SendSafely API Secret                                 |
| ACTION     | Must be `ADD_FILE`                                        |
| PACKAGE_ID | The ID of the SendSafely Package to get information about |
| FILE_PATH  | The path to the file on the local filesystem              |

**Example**

```bash
gradle bootRun --args='API_KEY=### API_SECRET=### ACTION=ADD_FILE PACKAGE_ID=### FILE_PATH=###'
```

### Add Recipient to Package

Add a recipient to an existing package.

**Arguments**

| Argument   | Description                                               |
|------------|-----------------------------------------------------------|
| API_KEY    | The SendSafely API Key                                    |
| API_SECRET | The SendSafely API Secret                                 |
| ACTION     | Must be `ADD_RECIPIENT`                                   |
| PACKAGE_ID | The ID of the SendSafely Package to get information about |
| RECIPIENT  | The email address of the recipient                        |

**Example**

```bash
gradle bootRun --args='API_KEY=### API_SECRET=### ACTION=ADD_RECIPIENT PACKAGE_ID=### RECIPIENT=###'
```

### Remove File from Package

Remove a file from an existing package.

**Arguments**

| Argument   | Description                                               |
|------------|-----------------------------------------------------------|
| API_KEY    | The SendSafely API Key                                    |
| API_SECRET | The SendSafely API Secret                                 |
| ACTION     | Must be `REMOVE_FILE`                                     |
| PACKAGE_ID | The ID of the SendSafely Package to get information about |
| SS_ID      | The SendSafely ID of the file to remove                   |

**Example**

```bash
gradle bootRun --args='API_KEY=### API_SECRET=### ACTION=REMOVE_FILE PACKAGE_ID=### SS_ID=###'
```

### Remove Recipient from Package

Remove a recipient from an existing package.

**Arguments**

| Argument   | Description                                               |
|------------|-----------------------------------------------------------|
| API_KEY    | The SendSafely API Key                                    |
| API_SECRET | The SendSafely API Secret                                 |
| ACTION     | Must be `REMOVE_RECIPIENT`                                |
| PACKAGE_ID | The ID of the SendSafely Package to get information about |
| SS_ID      | The SendSafely ID of the recipient to remove              |

**Example**

```bash
gradle bootRun --args='API_KEY=### API_SECRET=### ACTION=REMOVE_RECIPIENT PACKAGE_ID=### SS_ID=###'
```