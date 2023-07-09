# Discogs BigQuery importer

## Raison d'être

Scio Dataflow job to load the [discogs xml dumps](https://discogs-data-dumps.s3.us-west-2.amazonaws.com/index.html) into BigQuery tables.

## Running

Current available jobs: 

- [ ] Labels
- [x] Artists
- [x] Masters
- [x] Releases

To run the jobs, download the compressed XML dumps and upload them to your own gcp bucket.
Follow the [Scio instructions](https://spotify.github.io/scio/Getting-Started.html) to set up your GCP project.

### Releases

```
sbt "runMain discogs.ReleasesJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/releases.xml.gz
  --output=your-project.bq-dataset.releases-bq-table"
```

### Artists

```
sbt "runMain discogs.ArtistsJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/artists.xml.gz
  --output=your-project.bq-dataset.artists-bq-table"
```

### Masters

```
sbt "runMain discogs.MastersJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/masters.xml.gz
  --output=your-project.bq-dataset.masters-bq-table"
```
