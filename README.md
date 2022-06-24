# Send Safely Backend Assessment

This is the backend coding assessment for Craig Miller's interview with Send Safely.

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