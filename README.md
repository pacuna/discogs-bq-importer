# Discogs BigQuery importer

## Raison d'être

Scio Dataflow job to load the [discogs xml dumps](https://discogs-data-dumps.s3.us-west-2.amazonaws.com/index.html) into a BigQuery table

## Running

Current available jobs: 

- [ ] Labels
- [ ] Artists
- [ ] Masters
- [x] Releases

To run the releases job, download the releases xml compressed dump and upload it to your own gcp bucket.
Follow the [Scio instructions](https://spotify.github.io/scio/Getting-Started.html) to set up your GCP project. The releases job takes about 1 hour to complete using the default run settings.

Command:

```
sbt "runMain discogs.ReleasesJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/releases.xml.gz
  --output=your-project.bq-dataset.bq-table"
```