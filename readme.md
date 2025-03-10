# Parcel Tracking Number Generation API

This project implements a RESTful API using **Spring Boot** and **Java 17** to generate unique tracking numbers for parcels. The API supports high concurrency, is scalable, and ensures that tracking numbers are unique.

## Features

- **Generates Unique Tracking Numbers**: Ensures no duplicate tracking numbers are generated.
- **Scalable**: The system is designed to handle high concurrency and can scale horizontally.
- **Efficient**: The tracking number generation process is optimized for performance.
- **Customizable**: The API accepts multiple query parameters to generate tracking numbers based on origin country, destination country, weight, timestamp, customer details, etc.

## API Endpoint

### `GET /next-tracking-number`

Generates a new unique tracking number for the given parcel details.

#### Query Parameters

- `origin_country_id` (String): The origin country code (ISO 3166-1 alpha-2 format, e.g., "MY").
- `destination_country_id` (String): The destination country code (ISO 3166-1 alpha-2 format, e.g., "ID").
- `weight` (double): The weight of the parcel in kilograms, up to three decimal places (e.g., "1.234").
- `created_at` (String): The order's creation timestamp in RFC 3339 format (e.g., "2018-11-20T19:29:32+08:00").
- `customer_id` (String): The customer's UUID (e.g., "de619854-b59b-425e-9db4-943979e1bd49").
- `customer_name` (String): The customer's name (e.g., "RedBox Logistics").
- `customer_slug` (String): The customer's name in slug-case (e.g., "redbox-logistics").

#### Response Structure

The API returns the following JSON object:

```json
{
  "tracking_number": "ABC123XYZ4567890",
  "created_at": "2025-03-10T12:34:56+00:00"
}
